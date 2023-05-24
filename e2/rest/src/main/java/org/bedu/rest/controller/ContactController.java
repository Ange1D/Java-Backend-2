package org.bedu.rest.controller;

import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.bedu.rest.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {

    private AgendaService agenda;

    @Autowired
    public ContactController(AgendaService agenda){
        this.agenda = agenda;
    }

    //GET /contacts -> Obtener todos los contactos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> getContacts(){
        return agenda.getAll();
    }

    //GET /contacts/nombre -> Obtener un contacto
    @GetMapping("{name}")
    public Contact getContactByName(@PathVariable("name") String name) {
        return agenda.getOne(name);
    }

    //POST /conctacts -> Crear un contacto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact contact) {
        return agenda.add(contact);
    }

    //PUT /conctacts/nombre -> Actualizar un contacto
    @PutMapping("{name}")
    public void updateContacto(@RequestBody UpdatedContact contact, @PathVariable("name") String name){
        agenda.update(name, contact);
    }

    //DELETE /conctacts/nombre -> Eliminar un contacto
    @DeleteMapping("{name}")
    public void deleteContacto(@PathVariable("name") String name){
        agenda.remove(name);
    }

}
