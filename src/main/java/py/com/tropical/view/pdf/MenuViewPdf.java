package py.com.tropical.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import py.com.tropical.entity.Menu;
import py.com.tropical.entity.MenuPlatos;

@Component("menus/show")
public class MenuViewPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Menu menu = (Menu) model.get("menu");
		Paragraph tituloHeader = new Paragraph("Reporte de Menu",FontFactory.getFont(FontFactory.TIMES_ITALIC,18));
		tituloHeader.setAlignment(Element.ALIGN_CENTER);
		tituloHeader.setSpacingAfter(30);
		PdfPTable titulo = new PdfPTable(1);
		titulo.setSpacingAfter(10);
		PdfPCell cell = new PdfPCell(new Phrase("Menu: "+menu.getNombre(),FontFactory.getFont(FontFactory.TIMES,20)));
		cell.setBorder(Rectangle.NO_BORDER);
		titulo.addCell(cell);
		
		PdfPTable tabla = new PdfPTable(3);
		tabla.setSpacingAfter(20);
		
		PdfPCell cellId = new PdfPCell(new Phrase("ID",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
		cellId.setBackgroundColor(Color.DARK_GRAY);
		cellId.setBorder(Rectangle.LEFT);
		cellId.setPadding(8f);
		tabla.addCell(cellId);
		PdfPCell cellNombre = new PdfPCell(new Phrase("Nombre",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
		cellNombre.setBackgroundColor(Color.DARK_GRAY);
		cellNombre.setBorder(Rectangle.NO_BORDER);
		cellNombre.setPadding(8f);
		tabla.addCell(cellNombre);
		PdfPCell cellDescripcion = new PdfPCell(new Phrase("Descripcion",FontFactory.getFont(FontFactory.HELVETICA, 15, Color.WHITE)));
		cellDescripcion.setBackgroundColor(Color.DARK_GRAY);
		cellDescripcion.setBorder(Rectangle.RIGHT);
		cellDescripcion.setPadding(8f);
		tabla.addCell(cellDescripcion);
		
		List<MenuPlatos> menuPlatos = menu.getMenuPlatos();
		for(MenuPlatos menuPlato :menuPlatos) {
			tabla.addCell(String.valueOf(menuPlato.getPlato().getId()));
			tabla.addCell(String.valueOf(menuPlato.getPlato().getNombre()));
			tabla.addCell(String.valueOf(menuPlato.getPlato().getDescripcion()));
			
		}
		document.add(tituloHeader);
		document.add(titulo);
		document.add(tabla);
	}

}
