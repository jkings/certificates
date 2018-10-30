/**
 * Cliente.java
 * Creation Date: 30/10/2018, 12:11:33
 *
 */
package org.jkings.spring.x509.certificates.controllers;

import org.jkings.spring.x509.certificates.model.Client;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * This class contain client controller
 * @author @jkingsj (reyesmjm@gmail.com)
 * @version 1.0
 * @since Passport 1.0
 */

@RestController
@RequestMapping("/client")
@Secured("ROLE_USER")
public class ClientController {

  @GetMapping("/{id}")
  public Client GetCustomer(@PathVariable Long id) {
      return new Client(id, "Client " + id);
  }
  

}
