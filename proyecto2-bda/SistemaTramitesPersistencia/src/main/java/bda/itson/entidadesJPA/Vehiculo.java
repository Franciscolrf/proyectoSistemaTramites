package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long id;
    private String numeroSerie;
    private String estado;
    private String color;
    private String modelo;
    private String marca;
    private String linea;
    private String tipoVehiculo; 

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona propietario;

   @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Placa> placas;

    /**
     * Constructor vacío
     */
    public Vehiculo() {
    }

    /**
     * Constructor que recibe todo.
     * @param id
     * @param numeroSerie
     * @param estado
     * @param color
     * @param modelo
     * @param marca
     * @param linea
     * @param tipoVehiculo
     * @param propietario
     * @param placas 
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

    /**
     * Constructor que recibe todo excepto el ID.
     * @param numeroSerie
     * @param estado
     * @param color
     * @param modelo
     * @param marca
     * @param linea
     * @param tipoVehiculo
     * @param propietario
     * @param placas 
     */
    public Vehiculo(String numeroSerie, String estado, String color, String modelo, String marca, String linea, String tipoVehiculo, Persona propietario, List<Placa> placas) {
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
    
    /**
     * Constructor que recibe todo excepto el id y la lista de placas.
     * @return 
     */
    public Vehiculo(String numeroSerie, String estado, String color, String modelo, String marca, String linea, String tipoVehiculo, Persona propietario) {
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
    }

    /**
     * Método que regresa el tipo de vehículo
     * @return
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Método que establece el tipo de vehículo
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    /**
     * Método que regresa el id del vehículo
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que recibe el id del vehículo
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa el estado del vehículo
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado del vehículo
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa el color del vehículo
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que establece el color del vehículo
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método que regresa el modelo del vehículo
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el modelo del vehículo
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que regresa la marca del vehículo
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que establece la marca del vehículo
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que regresa la línea del vehículo
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Método que establece la línea del vehículo
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Método que regresa el propietario
     *
     * @return
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * Método que establece el propietario
     *
     * @param propietario
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    /**
     * Método que regresa las placas
     *
     * @return
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Método que establece las placas
     *
     * @param placas
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Método que regresa el número de serie
     * @return
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Método que establece el número de serie
     * @param numeroSerie
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    
    
    /*
     * Método que regresa el hash
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     * Método que regresa si dos objetos son iguales
     * @param object
     * @return true si son iguales, false si no
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
     * Método que regresa el objeto en forma de string
     * @return cadena
     */
    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", estado=" + estado + ", color=" + color + ", modelo=" + modelo + ", marca="
                + marca + ", linea=" + linea + ", propietario=" + propietario + "]";
    }

}
