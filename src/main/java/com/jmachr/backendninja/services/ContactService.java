package com.jmachr.backendninja.services;

import java.util.List;

import com.jmachr.backendninja.model.ContactModel;
import com.jmachr.backendninja.entity.Contact;

public interface ContactService {
    
    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAllContacts();

    public abstract Contact findContactById(int id);

    public abstract void removeContact(int id);

    public abstract ContactModel findContactByIdModel(int id);

    

}
