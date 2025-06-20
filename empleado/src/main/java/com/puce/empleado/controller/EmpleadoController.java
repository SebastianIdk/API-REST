package com.puce.empleado.controller;

import com.puce.empleado.model.EmpleadoModel; // Importación del modelo de empleado
import com.puce.empleado.service.EmpleadoService; // Importación del servicio de empleados
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación para inyección de dependencias
import org.springframework.web.bind.annotation.*; // Importación todas las rutas de Spring

import java.util.List;

@RestController // Anotación que indica que esta clase es un controlador REST
@RequestMapping("/api/v1/empleados") // Ruta base para todas las operaciones de este controlador
public class EmpleadoController {
    // Inyección de dependencia del servicio de empleados
    @Autowired
    private EmpleadoService svc;

    // - Métodos HTTP para manejar las operaciones CRUD de empleados
    // @PostMapping para crear un nuevo empleado
    @PostMapping
    public EmpleadoModel crear(@RequestBody EmpleadoModel e) {
        return svc.guardar(e);
    }

    // @GetMapping para listar todos los empleados, buscar por ID, email, sueldo mayor y experiencia mayor
    @GetMapping
    public List<EmpleadoModel> listar() {
        return svc.listarTodos();
    }

    // @PutMapping para actualizar un empleado existente
    @PutMapping
    public EmpleadoModel actualizar(@RequestBody EmpleadoModel e) {
        return svc.actualizar(e);
    }

    // @DeleteMapping para eliminar un empleado por su ID
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return svc.eliminar(id);
    }

    // @GetMapping con un email específico para buscar un empleado por su email
    @GetMapping("/email/{email}")
    public EmpleadoModel porEmail(@PathVariable String email) {
        return svc.buscarPorEmail(email);
    }

    // @GetMapping con un ID específico para buscar un empleado por su ID
    @GetMapping("/{id}")
    public EmpleadoModel porId(@PathVariable int id) {
        return svc.buscarPorId(id);
    }

    // @GetMapping con parámetros para buscar empleados con sueldo mayor a un valor dado
    @GetMapping("/sueldo-mayor")
    public List<EmpleadoModel> sueldoMayor(@RequestParam(defaultValue = "1000") double min) {
        return svc.sueldoMayorA(min);
    }

    // @GetMapping con parámetros para buscar empleados con experiencia mayor a un valor dado
    @GetMapping("/experiencia-mayor")
    public List<EmpleadoModel> experienciaMayor(@RequestParam(defaultValue = "5") int min) {
        return svc.experienciaMayorA(min);
    }
}