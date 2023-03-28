/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Book book;
    @OneToOne
    private Reader reader;
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeOnBookDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnBookDate;

    public History() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOnBookDate() {
        return takeOnBookDate;
    }

    public void setTakeOnBookDate(Date takeOnBookDate) {
        this.takeOnBookDate = takeOnBookDate;
    }

    public Date getReturnBookDate() {
        return returnBookDate;
    }

    public void setReturnBookDate(Date returnBookDate) {
        this.returnBookDate = returnBookDate;
    }

    @Override
    public String toString() {
        return "History{" 
                + "id=" + id 
                + ", book=" + book.getName()
                + ", reader=" + reader.getFirstname() 
                +" " + reader.getLastname()
                + ", takeOnBookDate=" + takeOnBookDate 
                + ", returnBookDate=" + returnBookDate 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.book);
        hash = 47 * hash + Objects.hashCode(this.reader);
        hash = 47 * hash + Objects.hashCode(this.takeOnBookDate);
        hash = 47 * hash + Objects.hashCode(this.returnBookDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.takeOnBookDate, other.takeOnBookDate)) {
            return false;
        }
        if (!Objects.equals(this.returnBookDate, other.returnBookDate)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
}
