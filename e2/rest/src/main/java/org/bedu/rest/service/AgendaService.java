package org.bedu.rest.service;

import org.bedu.rest.exception.ContactAlreadyExistsException;
import org.bedu.rest.exception.ContactNotFoundException;
import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AgendaService {
    private Map<String, Contact> agenda;
    public AgendaService(){
        agenda = new HashMap<String, Contact>();
        agenda.put("angel", new Contact("Angel","000000001"));
    }

    public boolean exists(String name){
        return agenda.containsKey(name.toLowerCase());
    }


    public List<Contact> getAll() {
        return new LinkedList<Contact>(agenda.values());
    }

    public Contact getOne(String name) {
        if(!exists(name)){
            throw new ContactNotFoundException(name);
        }
        return agenda.get(name.toLowerCase());
    }

    public Contact add(Contact contact){
        if (exists(contact.getName())){
            throw  new ContactAlreadyExistsException();
        }
        agenda.put(contact.getName().toLowerCase(), contact);
        return contact;
    }

    public void update(String name, UpdatedContact contact){
        Contact current = agenda.get(name);

        current.setNumber(contact.getNumber());

    }

    public void remove(String name){
        agenda.remove(name);
    }
}
