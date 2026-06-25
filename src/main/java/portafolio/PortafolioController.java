package portafolio;

import models.PrediccionBitcoins;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

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
    public String mostrarDashboardIA(Model model) {
        try {
            // 1. Instanciamos el cliente HTTP de Spring
            RestTemplate restTemplate = new RestTemplate();


            // URL del modelo IA en render
            String urlFastAPI = "https://api-ia-bitcoin.onrender.com/prediccion/bitcoin";

            // 3. Hacemos la petición GET y convertimos el JSON automáticamente a nuestra clase Java
            PrediccionBitcoins prediccionIA = restTemplate.getForObject(urlFastAPI, PrediccionBitcoins.class);

            // 4. Inyectamos el objeto lleno de datos hacia nuestra vista HTML
            model.addAttribute("datosIA", prediccionIA);

        } catch (Exception e) {
            // Si la API de Python está apagada, capturamos el error para que la página no colapse
            System.out.println("Error conectando con el motor de inferencia: " + e.getMessage());
            model.addAttribute("errorIA", "El motor predictivo se encuentra temporalmente fuera de línea.");
        }

        // ---------------------------------------------------------
        // 5. DATOS DEL GRÁFICO: Curva de Aprendizaje (Loss)
        // ---------------------------------------------------------
        // Estas son las épocas y el error que tuvo tu modelo en Colab
        List<String> labels = Arrays.asList("Epoch 1", "Epoch 2", "Epoch 3", "Epoch 4", "Epoch 5", "Epoch 6");
        List<Double> values = Arrays.asList(0.95, 0.45, 0.20, 0.08, 0.03, 0.01);

        model.addAttribute("labels", labels);
        model.addAttribute("values", values);

        return "dashboard"; // Tip: Spring Boot asume automáticamente que es ".html"
    }
}