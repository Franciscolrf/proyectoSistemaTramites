/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ID145
 */
@Entity
@Table(name="automovil")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipoAutomovil")
public class Automovil implements Serializable {

    // Atributos de la clase
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutomovil;

    private String tipoAutomovil;

    @OneToOne
    @JoinColumn(name="numeroSerieVehiculo", referencedColumnName="numeroSerie")
    private Vehiculo vehiculo;

    /**
     * Método que regresa el id del automovil	
     * @return
     */
    public Long getId() {
        return idAutomovil;
    }

    /**
     * Constructor vacío
     */
    public Automovil() {}

    /**
     * Constructor que recibe todo, excepto el id
     * @param tipoAutomovil
     * @param vehiculo
     */
    public Automovil(String tipoAutomovil, Vehiculo vehiculo) {
        this.tipoAutomovil = tipoAutomovil;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor que recibe todo.
     * @param idAutomovil
     * @param tipoAutomovil
     * @param vehiculo
     */

    public Automovil(Long idAutomovil, String tipoAutomovil, Vehiculo vehiculo) {
        this.idAutomovil = idAutomovil;
        this.tipoAutomovil = tipoAutomovil;
        this.vehiculo = vehiculo;
    }



    /**
     * Método que establece el id del automovil
     * @param idAutomovil
     */
    public void setId(Long idAutomovil) {
        this.idAutomovil = idAutomovil;
    }
    
    /**
     * Método que regresa el tipo de automovil
     * @return
     */
    public String getTipoAutomovil() {
        return tipoAutomovil;
    }

    /**
     * Método que establece el tipo de automovil
     * @param tipoAutomovil
     */
    public void setTipoAutomovil(String tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    /**
     * Método que regresa el vehiculo
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método que establece el vehiculo
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método que regresa el id del objeto
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomovil != null ? idAutomovil.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara dos objetos
     * @param object
     * @return true si son iguales, false si no
     * 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.idAutomovil == null && other.idAutomovil != null) || (this.idAutomovil != null && !this.idAutomovil.equals(other.idAutomovil))) {
            return false;
        }
        return true;
    }


    /**
     * Método que regresa el objeto en forma de cadena
     * @return Cadena con los atributos del objeto
     */
    @Override
    public String toString() {
        return "Automovil [idAutomovil=" + idAutomovil + ", tipoAutomovil=" + tipoAutomovil + ", vehiculo=" + vehiculo
                + "]";
    }

    
    
    
}
