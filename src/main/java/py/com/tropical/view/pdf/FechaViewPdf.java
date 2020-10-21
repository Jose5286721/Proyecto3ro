package py.com.tropical.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.util.List;
import py.com.tropical.entity.Fecha;
import py.com.tropical.entity.MenuConcretoPlatos;

@Component("fechas/show")
public class FechaViewPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Fecha> fechas =(List<Fecha>) model.get("fechas");
		Paragraph tituloHeader = new Paragraph("Reporte de Fechas",FontFactory.getFont(FontFactory.TIMES_ITALIC,18));
		tituloHeader.setAlignment(Element.ALIGN_CENTER);
		tituloHeader.setSpacingAfter(30);
		document.add(tituloHeader);
		
		for(Fecha fecha: fechas) {
			PdfPTable fechaTable = new PdfPTable(2);
			PdfPCell cellFecha = new PdfPCell(new Phrase("Fecha",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellFecha.setBackgroundColor(Color.DARK_GRAY);
			cellFecha.setBorder(Rectangle.LEFT);
			cellFecha.setPadding(8f);
			fechaTable.addCell(cellFecha);
			PdfPCell cellTemp = new PdfPCell(new Phrase("Temperatura",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellTemp.setBackgroundColor(Color.DARK_GRAY);
			cellTemp.setBorder(Rectangle.RIGHT);
			cellTemp.setPadding(8f);
			fechaTable.addCell(cellTemp);
			fechaTable.addCell(fecha.getFecha().toString());
			fechaTable.addCell(fecha.getTemperatura());
			
			
			PdfPTable detalle = new PdfPTable(4);
			detalle.setSpacingBefore(10);
			detalle.setSpacingAfter(20);
			PdfPCell cellId = new PdfPCell(new Phrase("ID",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellId.setBackgroundColor(Color.DARK_GRAY);
			cellId.setBorder(Rectangle.LEFT);
			cellId.setPadding(8f);
			detalle.addCell(cellId);
			PdfPCell cellMenu = new PdfPCell(new Phrase("Menu",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellMenu.setBackgroundColor(Color.DARK_GRAY);
			cellMenu.setBorder(Rectangle.NO_BORDER);
			cellMenu.setPadding(8f);
			detalle.addCell(cellMenu);
			PdfPCell cellPlato = new PdfPCell(new Phrase("Plato",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellPlato.setBackgroundColor(Color.DARK_GRAY);
			cellPlato.setBorder(Rectangle.NO_BORDER);
			cellPlato.setPadding(8f);
			detalle.addCell(cellPlato);
			PdfPCell cellPersonas = new PdfPCell(new Phrase("Personas",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
			cellPersonas.setBackgroundColor(Color.DARK_GRAY);
			cellPersonas.setBorder(Rectangle.RIGHT);
			cellPersonas.setPadding(8f);
			detalle.addCell(cellPersonas);
			for(MenuConcretoPlatos menuConcretoPlato : fecha.getMenuConcretoPlatos()) {
				detalle.addCell(String.valueOf(menuConcretoPlato.getId()));
				detalle.addCell(fecha.getMenu().getNombre());
				detalle.addCell(menuConcretoPlato.getPlato().getNombre());
				detalle.addCell(String.valueOf(menuConcretoPlato.getNumPersonas()));
			}
			document.add(fechaTable);
			document.add(detalle);
		}
		
		
	}

}
