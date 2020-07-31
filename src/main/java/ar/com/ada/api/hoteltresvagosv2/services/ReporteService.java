package ar.com.ada.api.hoteltresvagosv2.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.hoteltresvagosv2.repos.*;
import ar.com.ada.api.hoteltresvagosv2.entities.reportes.*;

@Service
public class ReporteService {

    @Autowired
    ReservaRepository reporteRepo;

    public List<ReporteEstado> getReporteReservasPorEstado() {

        return reporteRepo.getReporteReservasPorEstado();
    }

    public List<ReportePorHuesped> getReporteReservasPorHuespedes() {

        return reporteRepo.getReporteReservasPorHuespedes();
    }

}