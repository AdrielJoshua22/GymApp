package manager;

import model.Pagos;
import model.Socio;
import util.TicketPago;

public class ComprobanteManager {

    public void generarComprobante(Pagos pago, Socio socio) {
        if (pago == null || socio == null) {
            System.out.println("No se puede generar el comprobante: datos incompletos.");
            return;
        }

        System.out.println(pago.generarComprobante());
        TicketPago.generarArchivo(pago, socio);
    }
}