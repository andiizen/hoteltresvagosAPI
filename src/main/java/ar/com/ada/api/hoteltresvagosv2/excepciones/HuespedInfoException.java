package ar.com.ada.api.hoteltresvagosv2.excepciones;

import ar.com.ada.api.hoteltresvagosv2.entities.*;

public class HuespedInfoException extends Exception {

    private Huesped huesped;

    public HuespedInfoException(Huesped huesped, String mensaje) {

        super(huesped.getNombre() + ":" + mensaje);
        this.huesped = huesped;
    }
}
