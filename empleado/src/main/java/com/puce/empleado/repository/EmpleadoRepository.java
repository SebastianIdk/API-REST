package com.puce.empleado.repository;

import com.puce.empleado.model.EmpleadoModel; // Importación del modelo de empleado
import org.springframework.stereotype.Repository;

import java.util.*; // Importación de todas las clases
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EmpleadoRepository { // Clase que actúa como repositorio de empleados, simulando una base de datos en memoria
    private final Map<Integer, EmpleadoModel> almacenamiento = new HashMap<>(); // Mapa para almacenar empleados, donde la clave es el ID del empleado
    private final AtomicInteger seq = new AtomicInteger(1); // Secuencia para generar IDs unicos para nuevos empleados

    // Método que guarda un empleado, asignando un ID si es nuevo
    public EmpleadoModel save(EmpleadoModel e) {
        if (e.getId() == 0) {
            e.setId(seq.getAndIncrement());
        }
        almacenamiento.put(e.getId(), e);
        return e;
    }

    // Método que devuelve todos los empleados almacenados
    public List<EmpleadoModel> getAll() {
        return new ArrayList<>(almacenamiento.values());
    }

    // Método que busca un empleado por ID, devolviendo un Optional para manejar la ausencia de resultados
    public Optional<EmpleadoModel> findById(int id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    // Método que elimina un empleado por ID
    public String delete(int id) {
        return almacenamiento.remove(id) != null
            ? "Empleado eliminado"
            : "No existe empleado con id: " + id;
    }

    // Método que actualiza un empleado
    public EmpleadoModel update(EmpleadoModel e) {
        if (almacenamiento.containsKey(e.getId())) {
            almacenamiento.put(e.getId(), e);
            return e;
        }
        return null;
    }

    // Método que busca un empleado por email
    public Optional<EmpleadoModel> findByEmail(String email) {
        return almacenamiento.values().stream()
            .filter(emp -> emp.getEmail().equalsIgnoreCase(email))
            .findFirst();
    }

    // Método que busca empleados con sueldo mayor a un valor dado
    public List<EmpleadoModel> findBySueldoGreaterThan(double min) {
        return almacenamiento.values().stream()
            .filter(emp -> emp.getSueldo() > min)
            .collect(Collectors.toList());
    }

    // Método que busca empleados con años de experiencia mayor a un valor dado
    public List<EmpleadoModel> findByAniosExperienciaGreaterThan(int min) {
        return almacenamiento.values().stream()
            .filter(emp -> emp.getAniosExperiencia() > min)
            .collect(Collectors.toList());
    }
}