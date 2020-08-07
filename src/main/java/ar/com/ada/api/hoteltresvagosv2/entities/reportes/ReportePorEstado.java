package ar.com.ada.api.hoteltresvagosv2.entities.reportes;

import java.math.BigDecimal;

import javax.persistence.Column;

/**
 * https://stackoverflow.com/questions/36328063/how-to-return-a-custom-object-from-a-spring-data-jpa-group-by-query
 */
public interface ReportePorEstado {

    Integer getEstadoId();

    Integer getCantidadReservas();

    BigDecimal getTotalImporteReserva();

    BigDecimal getTotalImportePagado();

    BigDecimal getImporteTotal();

    String getDescripcion();

}