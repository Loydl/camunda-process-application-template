package ch.loydl.camunda.service.impl;

import java.util.Arrays;
import java.util.List;

/**
 * Choose from these for example data generation.
 */
final class RawData {

    static final List<String> FIRST_NAMES = Arrays.asList(
        "Armin", "Angelika",
        "Berthold", "Barbara",
        "Christian", "Clarissa",
        "Dieter", "Diana",
        "Emil", "Elaine",
        "Fritz", "Flora",
        "Gunther", "Gisela",
        "Hartmut", "Hildgard",
        "Ingo", "Isolde",
        "Jochen", "Josephine",
        "Klaus", "Karin",
        "Ludwig", "Lisbeth",
        "Markus", "Michaela",
        "Norbert", "Nora",
        "Ottokar", "Ottilie",
        "Paul", "Petra",
        "Quirin",
        "Richard", "Rosalie",
        "Siegmund", "Stefanie",
        "Thorwald", "Teresa",
        "Ulrich", "Ursula",
        "Valentin", "Veronika",
        "Waldemar", "Wiebke",
        "Xaver", "Xenia",
        "Yasmin",
        "Zeno", "Zora"
    );
    static final List<String> LAST_NAMES = Arrays.asList(
        "Angler", "Bauer", "Christ", "Decker", "Ecker", "Fischer", "Gartner",
        "Huber", "Ilgner", "Joseph", "Kaiser", "Leopold", "Maier", "Neuhauser",
        "Opitz", "Pflug", "Quantz", "Richter", "Schultze", "Toepfer", "Utz",
        "Vorndran", "Wiechert", "Zecher"
    );
    static final List<String> COMPANY_NAMES = Arrays.asList(
        "Apple", "BASE", "Computec", "Dell", "Emmerson", "FirstSpirit",
        "Gamble", "Hitachi", "Ibanez", "Jetbrains", "Karman", "Ludwig",
        "Microsoft", "Nokia", "Oracle", "Phase", "Quantas", "Roland",
        "SAP", "Terracotta", "Unilever", "Vertex", "Walther", "Xeno",
        "Zumba"
    );
    static final List<String> COMPANY_EXT = Arrays.asList(
        "AG", "GmbH", "S.A.", "Lim.", "Corp", "KG", "S.A.R.L"
    );

    private RawData() {}
}
