package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Clase que representa una entidad vehiculo
 *
 * @author ID145
 */
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {
    // Atributos de la clase

    /**
     * Identificador único del vehículo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador del vehículo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long id;

    /**
     * Número de serie del vehículo.
     */
    private String numeroSerie;

    /**
     * Estado del vehículo.
     */
    private String estado;

    /**
     * Color del vehículo.
     */
    private String color;

    /**
     * Modelo del vehículo.
     */
    private String modelo;

    /**
     * Marca del vehículo.
     */
    private String marca;

    /**
     * Línea del vehículo.
     */
    private String linea;

    /**
     * Tipo de vehículo.
     */
    private String tipoVehiculo;

    /**
     * Propietario del vehículo.
     */
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona propietario;

    /**
     * Placas asociadas al vehículo.
     */
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Placa> placas;

    // Constructores
    /**
     * Constructor vacío.
     */
    public Vehiculo() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Vehiculo.
     *
     * @param id Identificador del vehículo.
     * @param numeroSerie Número de serie del vehículo.
     * @param estado Estado del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param tipoVehiculo Tipo de vehículo.
     * @param propietario Propietario del vehículo.
     * @param placas Placas asociadas al vehículo.
     */
    public Vehiculo(Long id, String numeroSerie, String estado, String color, String modelo, String marca, String linea, String tipoVehiculo, Persona propietario, List<Placa> placas) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
        this.placas = placas;
    }

    // Métodos getters y setters
    /**
     * Método que obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Método que establece el tipo de vehículo.
     *
     * @param tipoVehiculo El tipo de vehículo a establecer.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Método que regresa el id del vehículo.
     *
     * @return El id del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el id del vehículo.
     *
     * @param id El id del vehículo a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa el estado del vehículo.
     *
     * @return El estado del vehículo.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado del vehículo.
     *
     * @param estado El estado del vehículo a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa el color del vehículo.
     *
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que establece el color del vehículo.
     *
     * @param color El color del vehículo a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método que regresa el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el modelo del vehículo.
     *
     * @param modelo El modelo del vehículo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que regresa la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que establece la marca del vehículo.
     *
     * @param marca La marca del vehículo a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que regresa la línea del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Método que establece la línea del vehículo.
     *
     * @param linea La línea del vehículo a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Método que regresa el propietario del vehículo.
     *
     * @return El propietario del vehículo.
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * Método que establece el propietario del vehículo.
     *
     * @param propietario El propietario del vehículo a establecer.
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    /**
     * Método que regresa las placas asociadas al vehículo.
     *
     * @return La lista de placas asociadas al vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Método que establece las placas asociadas al vehículo.
     *
     * @param placas La lista de placas a establecer.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Método que regresa el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Método que establece el número de serie del vehículo.
     *
     * @param numeroSerie El número de serie a establecer.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /*
     * Método para generar el hashcode.
     *
     * @return El hashcode del vehículo.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     * Método para comparar objetos.
     *
     * @param object El objeto con el que se va a comparar.
     * @return true si son iguales, false si no lo son.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /*
     * Método que regresa el objeto en forma de cadena.
     *
     * @return La representación en cadena del objeto.
     */
    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", estado=" + estado + ", color=" + color + ", modelo=" + modelo + ", marca="
                + marca + ", linea=" + linea + ", propietario=" + propietario + "]";
    }
}
