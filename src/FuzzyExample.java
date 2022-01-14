import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;
public class FuzzyExample {

    public static void main(String[] args) {
        try {
            String fileName = args[0];
            int humidityLvl = Integer.parseInt(args[1]);
            int timeOfDay = Integer.parseInt(args[2]);
            int waterLvl = Integer.parseInt(args[3]);
            FIS fis = FIS.load(fileName, false);

            // show graphs of the fusification and defuzzification functions
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

            // setup input variables
            fuzzyRuleSet.setVariable("poziom_wilgotnosci", humidityLvl);
            fuzzyRuleSet.setVariable("poziom_wody_w_zbiorniku", waterLvl);
            fuzzyRuleSet.setVariable("pora_dnia", timeOfDay);

            // driver logic
            fuzzyRuleSet.evaluate();

            // show output graph
            fuzzyRuleSet.getVariable("intensywnosc_podlewania").chartDefuzzifier(true);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number of args");
        } catch (NumberFormatException ex) {
            System.out.println("Wrong parameter.");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}