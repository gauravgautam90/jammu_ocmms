import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class RefusalHWM {

	public File pdfFunction(String copyTo1,
				String indusName, String indAddress,
				String occName, String OtherDocumentsDetails, Date draftDate,
				String officerdesig,
				String officername, String refNo1,
				String appDate, String indDistrict,String indRegInstance,String appNo,String termCon)
				throws Exception {

		File tempFile = new File("certificate.pdf");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String e=sdf.format(draftDate);
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		Image image3 = Image.getInstance("images2/JHK_Logo.jpg");
		image3.scalePercent(50.0f);
		image3.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image3);

		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		// document.add(image);

		Paragraph space5 = new Paragraph();
		space5.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space5.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));

		// document.add(space5);
		// document.add(space5);

		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));

		document.add(space4);

		Paragraph para1 = new Paragraph();
		para1
				.add(new Chunk("J & K Pollution Control Committee",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,
								Font.BOLD)));

		para1.setAlignment(Element.ALIGN_CENTER);
		document.add(para1);
		document.add(space4);

		Paragraph para2 = new Paragraph();
		para2
				.add(new Chunk(
						"Jammu/Kashmir",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));

		para2.setAlignment(Element.ALIGN_CENTER);
		document.add(para2);

		Paragraph para3 = new Paragraph();
		para3
				.add(new Chunk(
						"www.jkspcb.nic.in",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));

		para3.setAlignment(Element.ALIGN_CENTER);
		document.add(para3);

		document.add(space4);

		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(100);
		float[] columnWidths1 = { 1f, 1f };
		table1.setWidths(columnWidths1);
		PdfPCell cell1 = new PdfPCell();

		cell1 = new PdfPCell(new Paragraph(new Chunk("Ref No.:  ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
						Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);

		cell1.setPadding(10.0f);
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk("Dated :  "
				+ e, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE - 1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1.setBorder(PdfPCell.NO_BORDER);

		cell1.setPadding(10.0f);
		table1.addCell(cell1);

		document.add(table1);
		// document.add(space4);

		Paragraph subHeading1 = new Paragraph();
		subHeading1
				.add(new Chunk(
						"Consent to Establish (CTE) under section 25 /26 of the Water (Prevention & Control of Pollution) Act, 1974 and under section 21 of the Air (Prevention & Control of Pollution) Act, 1981",

						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
								Font.BOLD)));
		subHeading1.setAlignment(Element.ALIGN_LEFT);
		// document.add(subHeading1);

		// document.add(space4);

		Paragraph subHeading1aa = new Paragraph();
		subHeading1aa.add(new Chunk("   From,\n",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
		subHeading1aa.add(new Chunk("                     " + officername
				+ "\n                      " + officerdesig,

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL)));
		subHeading1aa.setAlignment(Element.ALIGN_LEFT);
		document.add(subHeading1aa);

		// document.add(space4);

		Paragraph subHeading1bb = new Paragraph();
		subHeading1bb.add(new Chunk("   To,\n",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
		subHeading1bb.add(new Chunk("                     " + occName
				+ "\n                      " + indusName
				+ "\n                      " + indAddress
				+ "\n                      " + indDistrict,

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL)));
		subHeading1bb.setAlignment(Element.ALIGN_LEFT);
		document.add(subHeading1bb);

		PdfPTable table1a = new PdfPTable(2);
		table1a.setWidthPercentage(100);
		float[] columnWidths1a = { 3f, 30f };
		table1a.setWidths(columnWidths1a);
		PdfPCell cell1a = new PdfPCell();

		cell1a = new PdfPCell(new Paragraph(new Chunk("Sub :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
		cell1a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1a.setVerticalAlignment(Element.ALIGN_TOP);
		cell1a.setBorder(PdfPCell.NO_BORDER);

		cell1a.setPadding(9.0f);
		table1a.addCell(cell1a);

		cell1a = new PdfPCell(
				new Paragraph(
						new Chunk(
								"Rejection of your application for Authorization under the Hazardous and Other Wastes (Management and Transboundary Movement) Rules, 2016- regarding.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE - 1, Font.BOLD))));
		cell1a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1a.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell1a.setBorder(PdfPCell.NO_BORDER);

		cell1a.setPadding(10.0f);
		table1a.addCell(cell1a);

		document.add(table1a);

		Paragraph subHeading1cc = new Paragraph();
		subHeading1cc.add(new Chunk("    Sir,\n",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
		subHeading1cc
				.add(new Chunk(
						"                      Whereas, you have applied for grant of Authorization under the Hazardous and Other Wastes (Management and Transboundary Movement) Rules, 2016 vide your application no. "
								+ appNo + " dated " + appDate + ".",

						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
								Font.NORMAL)));
		subHeading1cc.setAlignment(Element.ALIGN_LEFT);
		document.add(subHeading1cc);

		
		
		PdfPTable table1b = new PdfPTable(2);
		table1b.setWidthPercentage(100);
		float[] columnWidths1b = { 5f, 50f };
		table1b.setWidths(columnWidths1b);
		PdfPCell cell1b = new PdfPCell();

		cell1b = new PdfPCell(new Paragraph(new Chunk(""
				+ termCon, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE - 1, Font.NORMAL))));
		cell1b.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1b.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell1b.setBorder(PdfPCell.NO_BORDER);
		cell1b.setColspan(2);
		cell1b.setPadding(10.0f);
		table1b.addCell(cell1b);

		document.add(table1b);

		Paragraph subHeading1e = new Paragraph();
		subHeading1e
				.add(new Chunk(
						"                      The competent authority has, therefore, been pleased to reject your application No. "
								+ appNo
								+ " dated "
								+ appDate
								+ " and undersigned directs you not to carry out any construction-work at this proposed site",

						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
								Font.NORMAL)));
		subHeading1e.setAlignment(Element.ALIGN_LEFT);
		document.add(subHeading1e);

		Paragraph subHeading1f = new Paragraph();
		subHeading1f.add(new Chunk("Yours faithfully,    ",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL)));
		subHeading1f.setAlignment(Element.ALIGN_RIGHT);
		document.add(subHeading1f);

		document.add(space4);

		Paragraph subHeading1g = new Paragraph();
		subHeading1g.add(new Chunk("" + officername + "         \n"
				+ officerdesig + "         ",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL)));
		subHeading1g.setAlignment(Element.ALIGN_RIGHT);
		document.add(subHeading1g);

		document.add(space4);

		PdfPTable table1q = new PdfPTable(2);
		table1q.setWidthPercentage(100);
		float[] columnWidths1q = { 1f, 1f };
		table1.setWidths(columnWidths1q);
		PdfPCell cell1q = new PdfPCell();

		cell1q = new PdfPCell(new Paragraph(new Chunk(
				"Memo No.:  " + "", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
		cell1q.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1q.setBorder(PdfPCell.NO_BORDER);

		cell1q.setPadding(10.0f);
		table1q.addCell(cell1q);

		cell1q = new PdfPCell(new Paragraph(new Chunk("Dated :  "
				+ e, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE - 1, Font.NORMAL))));
		cell1q.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1q.setBorder(PdfPCell.NO_BORDER);

		cell1q.setPadding(10.0f);
		table1q.addCell(cell1q);

		document.add(table1q);
		document.add(space4);

		Paragraph subHeading1h = new Paragraph();
		subHeading1h.add(new Chunk("    Copy To :",

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
		subHeading1h.add(new Chunk("" + copyTo1,

		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL)));
		subHeading1h.setAlignment(Element.ALIGN_LEFT);
		document.add(subHeading1h);

		document.add(space4);

		document.add(subHeading1g);

		document.close();
		return tempFile;

	}

}
