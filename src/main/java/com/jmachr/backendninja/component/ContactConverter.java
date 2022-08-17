package com.jmachr.backendninja.component;

import org.springframework.stereotype.Component;

import com.jmachr.backendninja.model.ContactModel;
import com.jmachr.backendninja.entity.Contact;

@Component("contactConverter")
public class ContactConverter {
    
    public Contact convertContactModelToContact(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setCity(contactModel.getCity());
        contact.setFirstName(contactModel.getFirstName());
        contact.setId(contactModel.getId());
        contact.setLastName(contactModel.getLastName());
        contact.setTelephone(contactModel.getTelephone());
        
        return contact;
    }

    public ContactModel convertContactToContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setCity(contact.getCity());
        contactModel.setFirstName(contact.getFirstName());
        contactModel.setId(contact.getId());
        contactModel.setLastName(contact.getLastName());
        contactModel.setTelephone(contact.getTelephone());
        return contactModel;
    }

}
