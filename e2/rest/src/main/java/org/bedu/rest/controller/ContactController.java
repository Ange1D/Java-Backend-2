package org.bedu.rest.controller;

import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("contacts")
public class ContactController {

    private Map<String, Contact> agenda;

    public ContactController(){
        agenda = new HashMap<String, Contact>();

        agenda.put("angel", new Contact("Angel","000000001"));
    }

    //GET /contacts -> Obtener todos los contactos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> getContacts(){
        return new LinkedList<Contact>(agenda.values());
    }

    //GET /contacts/nombre -> Obtener un contacto
    @GetMapping("{name}")
    public ResponseEntity<Contact> getContactByName(@PathVariable("name") String name){
        if(!agenda.containsKey(name)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(agenda.get(name.toLowerCase()));
    }

    //POST /conctacts -> Crear un contacto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact newContact) {
        agenda.put(newContact.getName().toLowerCase(), newContact);
        return newContact;
    }

    //PUT /conctacts/nombre -> Actualizar un contacto
    @PutMapping("{name}")
    public ResponseEntity<Void> updateContacto(@RequestBody UpdatedContact contact, @PathVariable("name") String name){
        if(!agenda.containsKey("name")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Contact current = agenda.get(name);

        current.setNumber(contact.getNumber());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //DELETE /conctacts/nombre -> Eliminar un contacto
    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteContacto(@PathVariable("name") String name){
        if(!agenda.containsKey("name")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        agenda.remove(name);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
