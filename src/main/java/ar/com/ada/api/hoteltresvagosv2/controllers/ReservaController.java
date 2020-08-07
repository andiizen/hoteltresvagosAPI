package ar.com.ada.api.hoteltresvagosv2.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.hoteltresvagosv2.entities.Reserva;
import ar.com.ada.api.hoteltresvagosv2.models.response.GenericResponse;
import ar.com.ada.api.hoteltresvagosv2.services.ReservaService;
import ar.com.ada.api.hoteltresvagosv2.entities.*;

@RestController
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/reservas")
    public List<Reserva> getReservas(@RequestParam(value = "nombre", required = false) String nombre) {
        List<Reserva> reservas;

        if (nombre == null) {
            reservas = reservaService.getReservas();
        } else {
            reservas = reservaService.buscarReservasPorNombre(nombre);
        }

        return reservas;
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) {
        Reserva res = reservaService.buscarPorId(id);

        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping("/reservas")
    public ResponseEntity<?> postReserva(@RequestBody Reserva reservaInfo) {

        GenericResponse r = new GenericResponse();
        boolean resultado = reservaService.crearReserva(reservaInfo);

        if (resultado) {
            r.isOk = true;
            r.id = reservaInfo.getReservaId();
            r.message = "Has creado una reserva con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "Ups, algo falló. No se pudo crear la reserva.";

            return ResponseEntity.badRequest().body(r);
        }

    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<?> putReserva(@PathVariable int id, @RequestBody Reserva reservaInfo) {

        GenericResponse r = new GenericResponse();

        Reserva reservaOriginal = reservaService.buscarPorId(id);

        if (reservaOriginal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean resultado = false;
        resultado = reservaService.actualizarReserva(reservaOriginal, reservaInfo);

        if (resultado) {
            r.isOk = true;
            r.id = reservaInfo.getReservaId();
            r.message = "Se ha actualizado la reserva con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "No se pudo actualizar la reserva.";

            return ResponseEntity.badRequest().body(r);
        }

    }
}