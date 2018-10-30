/**
 * Client.java
 * Creation Date: 30/10/2018, 12:15:11
 *
 */
package org.jkings.spring.x509.certificates.model;

/**
 * Class that contains a client people.
 * @author Juan Manuel Reyes Medina (jkings@cle.ninja)
 * @version 1.0
 * @since Passport 1.0
 */
public class Client {

  private Long id;
  private String name;

  public Client(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return the attribute name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name parameter name to update
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the attribute id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id parameter id to update
   */
  public void setId(Long id) {
    this.id = id;
  }

}
