package org.bedu.rest.controller;

import org.bedu.rest.exception.ContactAlreadyExistsException;
import org.bedu.rest.exception.ContactNotFoundException;
import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.bedu.rest.model.response.ErrorResponse;
import org.bedu.rest.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> getContactByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(agenda.getOne(name));
        } catch (ContactNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(name + " does not exist in agenda"));
        }
    }

    //POST /conctacts -> Crear un contacto
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createContact(@Valid @RequestBody Contact contact) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(agenda.add(contact));
        } catch (ContactAlreadyExistsException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(contact.getName() + " already exists in agenda"));
        }
    }

    //PUT /conctacts/nombre -> Actualizar un contacto
    @PutMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContacto( @Valid @RequestBody UpdatedContact contact, @PathVariable("name") String name){
        agenda.update(name, contact);
    }

    //DELETE /conctacts/nombre -> Eliminar un contacto
    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContacto(@PathVariable("name") String name){
        agenda.remove(name);
    }

}
