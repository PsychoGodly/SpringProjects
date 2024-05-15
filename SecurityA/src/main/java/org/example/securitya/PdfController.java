package org.example.securitya;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;




import com.itextpdf.text.pdf.PdfDocument;


@Controller
public class PdfController {

    @PostMapping("/generatePdf")
    public void generatePdf(@RequestParam String name, @RequestParam String email, HttpServletResponse response) throws IOException, DocumentException {
        // Créez un document PDF
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument document = new PdfDocument();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Nom : " + name));
        document.add(new Paragraph("Email : " + email));
        document.close();

        // Configurez la réponse HTTP pour télécharger le PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=user_info.pdf");

        // Écrivez le PDF dans la réponse HTTP
        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
    }
}
