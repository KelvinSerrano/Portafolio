package models;

public class PrediccionBitcoins {
    // Los nombres de las variables deben ser IGUALES a los del JSON de FastAPI
    private String moneda;
    private Double ultimoPrecioReal;
    private Double precioPredichoMañana;
    private String tendencia;

    // Constructores vacíos y con parámetros (buenas prácticas)
    public PrediccionBitcoins() {}

    // Getters y Setters (Imprescindibles para que Spring Boot y Thymeleaf puedan leer los datos)
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public Double getUltimoPrecioReal() { return ultimoPrecioReal; }
    public void setUltimoPrecioReal(Double ultimoPrecioReal) { this.ultimoPrecioReal = ultimoPrecioReal; }

    public Double getPrecioPredichoMañana() { return precioPredichoMañana; }
    public void setPrecioPredichoMañana(Double precioPredichoMañana) { this.precioPredichoMañana = precioPredichoMañana; }

    public String getTendencia() { return tendencia; }
    public void setTendencia(String tendencia) { this.tendencia = tendencia; }
}
