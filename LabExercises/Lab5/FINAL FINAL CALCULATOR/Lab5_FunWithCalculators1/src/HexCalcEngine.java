public class HexCalcEngine extends CalcEngine {

    protected boolean inHexMode = false;

    public HexCalcEngine() {
        super();
    }

    public void numberPressed(int number) {

        if (inHexMode) {
            if (buildingDisplayValue) {
                // Incorporate this digit.
                displayValue = displayValue * 16 + number;
            } else {
                // Start building a new number.
                displayValue = number;
                buildingDisplayValue = true;
            }
        }

        else
            super.numberPressed(number);
    }

    protected void setHexMode(boolean b) {
        inHexMode = b;
    }



}
