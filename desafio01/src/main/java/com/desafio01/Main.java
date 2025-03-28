package com.desafio01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        String pathdestinationPackage = "pdf/";
        Path zipFile = Paths.get("zipFiles/files.zip");
        Path filesToZip = Paths.get("pdf/");

        List<String> urlPdfs = List.of(
                "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf",
                "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf");

        List<String> fileNames = List.of("Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf",
                "Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf");

        for (int i = 0; i < urlPdfs.size(); i++) {
            // Download PDF
            var response = downloadPdf(urlPdfs.get(i));

            // Save PDF
            if (response.statusCode() == 200) {

                savePdf(response.body(), pathdestinationPackage, fileNames.get(i));
            } else {
                System.out.println("Algo na requisição deu errado!!!");
            }

        }
        zip(filesToZip, zipFile);
    }

    public static HttpResponse<InputStream> downloadPdf(String url) {

        try {
            HttpRequest request = HttpRequest
                    .newBuilder(new URI(url))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            return client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void savePdf(InputStream inputStream, String destinationPackage, String fileName) {

        try {

            File directory = new File(destinationPackage);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPackage + fileName)) {

                byte[] buffer = new byte[8192];
                int bytesRead;

                // Le os bytes do arquivo
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    // Salva no arquivo
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File: " + fileName + " Download completed!");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void zip(Path filesToZip, Path zipFile) {

        try {
            File directory = new File("zipFiles/");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
                    DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filesToZip)) {
                for (Path file : directoryStream) {
                    ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                    zipOutputStream.putNextEntry(zipEntry);
                    Files.copy(file, zipOutputStream);
                    zipOutputStream.closeEntry();
                }

                System.out.println("Finished zipping files.");
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}