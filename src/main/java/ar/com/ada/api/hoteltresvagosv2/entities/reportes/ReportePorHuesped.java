package ar.com.ada.api.hoteltresvagosv2.entities.reportes;

public interface ReportePorHuesped {

    public Integer getHuespedId();

    public String getNombre();

    public Double getImporteReserva();

    public Double getImportePagado();

    public Double getImporteTotal();

}