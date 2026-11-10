public interface Taxable {
    // ملاحظة: الثوابت في الواجهات تكون public static final تلقائيًا
    double TAX_RATE = 0.15;

    double calculateTax();
}
