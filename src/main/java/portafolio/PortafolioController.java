package portafolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView; // <-- Usaremos este import ahora

@Controller
public class PortafolioController {

    @GetMapping("/")
    public String mostrarPortafolio() {
        return "index";
    }

    @GetMapping("/demo")
    public String mostrarDemo() {
        return "demo";
    }

    @GetMapping("/dashboard")
    public ModelAndView mostrarDashboard() {
        // Le decimos que la vista a cargar es "dashboard.html"
        ModelAndView vista = new ModelAndView("dashboard");

        // Usamos addObject en lugar de addAttribute
        vista.addObject("ultimoPrecio", 76672.30);
        vista.addObject("precision", 98.5);
        vista.addObject("epocaConvergencia", 3);
        vista.addObject("iteraciones", 24);

        // Datos del gráfico
        vista.addObject("labels", new int[]{0, 5, 10, 15, 20, 24});
        vista.addObject("values", new double[]{0.034, 0.005, 0.004, 0.003, 0.0025, 0.0022});

        return vista;
    }
}