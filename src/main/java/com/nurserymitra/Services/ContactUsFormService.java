package com.nurserymitra.Services;

import com.nurserymitra.Entity.ContactUsForm;
import com.nurserymitra.Repository.ContactUsFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsFormService
{
    @Autowired
    ContactUsFormRepository c1;
    public void submitForm(ContactUsForm c)
    {
        c1.save(c);
    }

    public List<ContactUsForm> getAllQueries()
    {
        return c1.findAll();
    }

    public long getContactCount()
    {
        return c1.count();
    }

    public void deleteQuery(int id)
    {
        c1.deleteById(id);
    }
}
