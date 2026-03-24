package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
          if(line==null || line.isBlank()) continue;

          String[] parts= line.split(",");
            if(parts.length >= 3) {
                try {
                    String name = parts[0];
                    String email = parts[1];
                    int edad = Integer.parseInt(parts[2].trim());
                    result.add(name+" - "+ email+" - "+edad);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return result;
    }
    public void updatePerson(int index, String name, String email, String age) throws IOException {
       validarPerson(name,email,age);
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines =new ArrayList<>();
        for (String line : listaOriginal){
            if (line!=null && !line.isBlank()){
                cleanLines.add(line);//esta linea esta buena , ya que no es null y tampoco esta blanco

            }
        }
        cleanLines.set(index,name+","+email+","+age);
        repo.saveFile(cleanLines);//sustitui la info de el archivo dejandolo actualizado
    }
    public void delete(int index) throws IOException {
        //delete
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal) {
            if (line != null && !line.isBlank()) {
                cleanLines.add(line);
            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines);
    }
    public void addPerson(String name, String email, String edadt) throws IOException {
        validarPerson(name,email,edadt);
        repo.addNewLine(name+","+email+","+edadt);
    }
    private void validarPerson(String name, String email, String edad) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }

        String em = (email == null) ? "" : email.trim();

        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El correo es incorrecto");

        }
        try {

            int edadnum = Integer.parseInt(edad);
            if (edadnum < 18) {
                throw new IllegalArgumentException("Solo se permiten mayores de edad");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        }


    }


}
