package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.repository.AuthorRepository;
import com.sda.manandrada.bms.repository.AuthorRepositoryImpl;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl() {//sa nu aiba acces nimeni
        authorRepository = new AuthorRepositoryImpl();
    }

    @Override
    public void createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.createAuthor(author);

    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @Override
    public void importAuthorsFromFile() {
        //java neo folosim
        // Path authorsFilePath= Paths.get("/data/Authors.txt");
        Path authorsFileAbsolutePath = Paths.get("C:\\Users\\Dell\\Documents\\BookManagementSystem\\data\\Authors.txt.crdownload");

        //citire din fisier linie cu linie
        try {
            Files.lines(authorsFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)//eliminare prima linie,skip va sari un nr de lini,aici sarim o linie
                    .map(line -> {
                        try {
                            String[] lineElements = line.split("\\|"); //cu split sparg lista
                            Author author = new Author();
                            author.setFirstName(lineElements[0]);
                            author.setLastName(lineElements[1]);
                            return author;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })//conversia de la tip autor
                    .forEach(author -> {
                        if (author != null) {
                            authorRepository.createAuthor(author);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, String firstName, String lastName) throws AuthorNotFoundExceptions {
        Author author = authorRepository.findById(id);
        if (author != null) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorRepository.update(author);
        } else {
            throw new AuthorNotFoundExceptions("Author not found", id);
        }
    }

    @Override
    public void delete(Integer id) throws AuthorNotFoundExceptions {
        Author author = authorRepository.findById(id);
        if (author != null) {
            authorRepository.delete(author);
        } else {
            throw new AuthorNotFoundExceptions("Author not found", id);
        }
    }
}
