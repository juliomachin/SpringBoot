package com.jmachr.backendninja.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jmachr.backendninja.entity.Contact;
import com.jmachr.backendninja.model.ContactModel;
import com.jmachr.backendninja.repository.ContactRepository;
import com.jmachr.backendninja.services.ContactService;
import com.jmachr.backendninja.component.ContactConverter;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
        return contactConverter.convertContactToContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        
        List<Contact> contacts = contactRepository.findAll();
        List <ContactModel> contacstModels = new ArrayList<ContactModel>();
        for (Contact contact : contacts) {
            contacstModels.add( contactConverter.convertContactToContactModel(contact));
        }
        return contacstModels;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findContactById(id);
        
    }

    public ContactModel findContactByIdModel(int id){
        return contactConverter.convertContactToContactModel(findContactById(id));
    }

    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);
        if(contact != null){
            contactRepository.delete(contact);
        }
        
    }
    
}
