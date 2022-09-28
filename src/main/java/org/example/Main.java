package org.example;

import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;


public class Main {

    private static final String username = "Petremoul";

    public static void main(String[] args) throws IOException {

        //Url de base "https://www.breizhchrono.com"
        //instanciation du webScraper avec cet url
        WebScraper webScraper = new WebScraper();


        // Recherche dans la page d'un lien qui redirige vers la liste des courses
        HtmlAnchor anchorCourses = webScraper.findAnchorByText("Voir toutes les courses", webScraper.page);

        //redirection vers cette page à la suite du click sur le lien
        HtmlPage page2 = anchorCourses.click();


        // Recherche dans la page d'un lien contenant le texte "ROAZHON RUN"
        HtmlAnchor anchorRoazhonRun = webScraper.findAnchorByText("Roazhon Nocturne MGEN", page2);

        //redirection vers la page de la course à la suite du click sur le lien
        HtmlPage page3 = anchorRoazhonRun.click();


        // récupération du formulaire de recherche de la page
        HtmlForm form = page3.getHtmlElementById("ext-run-form-recherchedetailcourse");
        HtmlSubmitInput button = form.getInputByName("submitRechercheDetailCoureur");
        HtmlTextInput textField = form.getInputByName("coureur_search");

        // saisie du texte de la recherche
        textField.type(username);

        //soumission du formulaire
        final HtmlPage page4 = button.click();


        // récupération du tableau
        final HtmlTable table = page4.getHtmlElementById("detail-course");
        Coureur coureur = new Coureur();

        // extraction et affichage des données du coureur
        webScraper.extraireInformationCoureur(table, coureur);
        System.out.println(page4.getTitleText());
        System.out.println(coureur);

    }
}
