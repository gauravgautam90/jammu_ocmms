

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.*;


public class HeaderFooterPageEventNew extends PdfPageEventHelper {

	private PdfTemplate t;
	private Image total;

	public void onOpenDocument(PdfWriter writer, Document document) {
		t = writer.getDirectContent().createTemplate(30, 16);
		
			try {
				total = Image.getInstance(t);
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		
		addFooter(writer);
	}

	

	private void addFooter(PdfWriter writer) {
		PdfPTable footer = new PdfPTable(3);
		try {
			// set defaults
			footer.setWidths(new int[] { 24, 2, 1 });
			footer.setTotalWidth(527);
			footer.setLockedWidth(true);
			footer.getDefaultCell().setFixedHeight(40);
			footer.getDefaultCell().setBorder(Rectangle.TOP);
			footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

			// add copyright
			footer
					.addCell(new Phrase(
							""
									+ ""
									+ "                                               “This is computer generated document from OCMMS by JKPCC”                                                      "
									+"\n"+"                                                   This is a computer generated consent order (AUTO-RENEWAL) from JKPCC – issued under EoDB and does not require any signature"
									+"\n"+" Eliminate Single Use Plastic to make this planet a better place to live",
							new Font(FontFamily.HELVETICA,
									Font.DEFAULTSIZE - 4, Font.ITALIC)));

			// add current page count
			footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			footer.addCell(new Phrase(String.format("Page %d of", writer
					.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));
			System.out.println("Page %d of--or--"+(writer.getPageNumber()));
			System.out.println("Page %d of----"+(writer.getPageNumber()-1));
			// add placeholder for total page count
			PdfPCell totalPageCount = new PdfPCell(total);
			totalPageCount.setBorder(Rectangle.TOP);
			totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
			footer.addCell(totalPageCount);

			// write page
			PdfContentByte canvas = writer.getDirectContent();
			// canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
			footer.writeSelectedRows(0, -1, 34, 50, canvas);
			// canvas.endMarkedContentSequence();
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		int totalLength = String.valueOf(writer.getPageNumber()).length();
		int totalWidth = totalLength * 5;
		System.out.println("Page total----"+(writer.getPageNumber()-1));
		System.out.println("Page total--or--"+(writer.getPageNumber()));
		ColumnText.showTextAligned(t, Element.ALIGN_RIGHT, new Phrase(String
				.valueOf(writer.getPageNumber()-1), new Font(
				Font.FontFamily.HELVETICA, 8)), totalWidth, 6, 0);
	}
}
