package com.puce.empleado.service;

import com.puce.empleado.model.EmpleadoModel; // Importación del modelo de empleado
import com.puce.empleado.repository.EmpleadoRepository; // Importación del repositorio de empleados
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación para inyección de dependencias
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repo;

    public EmpleadoModel guardar(EmpleadoModel e) { // Método que guarda un empleado
        return repo.save(e);
    }

    public List<EmpleadoModel> listarTodos() { // Método que lista todos los empleados
        return repo.getAll();
    }

    public EmpleadoModel buscarPorId(int id) {
        return repo.findById(id) // Método que busca por ID
            .orElseThrow(() -> new RuntimeException("No existe empleado con id: " + id)); // Validación de ID
    }

    public EmpleadoModel buscarPorEmail(String email) {
        return repo.findByEmail(email) // Método que busca por email
            .orElseThrow(() -> new RuntimeException("No existe empleado con email: " + email)); // Validación de email
    }

    public List<EmpleadoModel> sueldoMayorA(double min) { // Método que busca empleados con sueldo mayor a un valor dado
        return repo.findBySueldoGreaterThan(min);
    }

    public List<EmpleadoModel> experienciaMayorA(int min) { // Método que busca empleados con experiencia mayor a un valor dado
        return repo.findByAniosExperienciaGreaterThan(min);
    }

    public EmpleadoModel actualizar(EmpleadoModel e) { // Método que actualiza un empleado
        EmpleadoModel updated = repo.update(e);
        if (updated == null) {
            throw new RuntimeException("No existe empleado con id: " + e.getId());
        }
        return updated;
    }

    public String eliminar(int id) { // Método que elimina un empleado por ID
        return repo.delete(id);
    }
}