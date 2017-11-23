package uk.ac.eb.pride.cluster.reanalysis.util;

import uk.ac.eb.pride.cluster.reanalysis.model.exception.PladipusProcessingException;
import uk.ac.eb.pride.cluster.reanalysis.processsteps.MultipleWebServiceSearchStep;

import java.util.HashMap;

/**
 *
 * @author JavaSaurus <javasaurusdev@gmail.com>
 */
public class MultipleFastaSearchRunner {

    //need 2 fasta files...
    public static String[] fastaPaths = new String[]{
        "F:/work/compomics/Fasta/Search/SwissProt_Canonical_Human_cRAP_05_2017_concatenated_target_decoy.fasta",
        "F:/work/compomics/Fasta/Search/BSwissProt_Canonical_Human_cRAP_05_2017_concatenated_target_decoy.fasta"
    //  "F:\\work\\compomics\\Fasta\\Search\\lncipedia_4_1_6RF5-30_concatenated_target_decoy.fasta"
    };

    public static String output_folder = "F:/work/compomics/Fasta/Search/results";

    public static String assay = "3";

    public static void main(String[] args) throws PladipusProcessingException {
        MultipleWebServiceSearchStep.SaveOnGoogleDrive=true;
        HashMap<String, String> parameters = SearchProperties.getInstance().getParameters();
        parameters.put("output_folder", output_folder);
        parameters.put("assay", assay);
        String fastas = "";
        for (String entry : fastaPaths) {
            fastas += entry + ",";
        }
        fastas = fastas.substring(0, fastas.length() - 1);
        parameters.put("fasta_file", fastas);

        //run the searches
        MultipleWebServiceSearchStep step = new MultipleWebServiceSearchStep();
        step.setParameters(parameters);
        step.doAction();
    }

}