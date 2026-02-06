public class ShippingCalculator {
    private final double IVA_PORCENTAJE = 0.16;
    private final double PRECIO_ESTANDAR = 50.0;
    private final double PRECIO_EXPRESS = 90.0;
    private final double COSTO_POR_KG = 12.0;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        double subtotal = 0;

        if (tipoServicio == 1) {
            subtotal = subtotal + PRECIO_ESTANDAR;
        } else {
            subtotal = subtotal + PRECIO_EXPRESS;
        }

        subtotal = subtotal + (pesoKg * COSTO_POR_KG);

        if (distanciaKm <= 50) {
            subtotal = subtotal + 20;
        } else if (distanciaKm <= 200) {
            subtotal = subtotal + 60;
        } else {
            subtotal = subtotal + 120;
        }

        if (esZonaRemota) {
            subtotal = subtotal * 1.10;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * IVA_PORCENTAJE;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}