package edu.uw.tacoma.db;

import edu.uw.tacoma.db.tag.*;

public class TemplateDataObject
{
	public static TagServer getServerObject()
	{
		int position;
		TagServer server = new TagServer("sample");

		TagDatabase database;
		server.host = "localhost";
		server.type = "sqlserver";
		server.user = "sa";
		server.pass = "";
		database = new TagDatabase("Amazon");
		
		TagTypeLang lint, lstr, ldt;
		lint = new TagTypeLang("Integer");
		lstr = new TagTypeLang("String");
		ldt = new TagTypeLang("Date");
		
		TagTypeSQL sint, sstr, sdt;
		sint = new TagTypeSQL("Int");
		sstr = new TagTypeSQL("String");
		sdt = new TagTypeSQL("Date");
		
		TagTypeValue defint, defstr, defdt;
		defint = new TagTypeValue("0");
		defstr = new TagTypeValue("\"\"");
		defdt = new TagTypeValue("null");
		
		position = 3;
		TagTable dept = new TagTable("Department");
		dept.add(new TagColumn("DeptID", new TagType("int"), lint, sint, defint, position++));
		dept.add(new TagColumn("DeptName", new TagType("varchar(50)"), lstr, sstr, defstr, position++));
		dept.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		dept.add(new TagKeyPrimary(dept.columns.get(0)));
		database.add(dept);
		
		position = 3;
		TagTable cat = new TagTable("Category");
		cat.add(new TagColumn("CategoryID", new TagType("int"), lint, sint, defint, position++));
		cat.add(new TagColumn("DeptID", new TagType("int"), lint, sint, defint, position++));
		cat.add(new TagColumn("CategoryName", new TagType("char(50)"), lstr, sstr, defstr, position++));
		cat.add(new TagKeyPrimary(cat.columns.get(0)));
		cat.add(new TagKeyForeign(cat.columns.get(1), dept, dept.columns.get(0)));
		database.add(cat);
		
		position = 3;
		TagTable product = new TagTable("Product");
		product.add(new TagColumn("ProductID", new TagType("int"), lint, sint, defint, position++));
		product.add(new TagColumn("CategoryID", new TagType("int"), lint, sint, defint, position++));
		product.add(new TagColumn("ProductName", new TagType("varchar(100)"), lstr, sstr, defstr, position++));
		product.add(new TagColumn("Color", new TagType("varchar(20)"), lstr, sstr, defstr, position++));
		product.add(new TagColumn("UnitPrice", new TagType("int"), lint, sint, defint, position++));
		product.add(new TagColumn("ShippingPrice", new TagType("int"), lint, sint, defint, position++));
		product.add(new TagColumn("Discount", new TagType("int"), lint, sint, defint, position++));
		product.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		product.add(new TagKeyPrimary(product.columns.get(0)));
		product.add(new TagKeyForeign(product.columns.get(1), cat, cat.columns.get(0)));
		database.add(product);
		
		position = 3;
		TagTable account = new TagTable("Account");
		account.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		account.add(new TagColumn("Name", new TagType("char(50)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("Address", new TagType("varchar(100)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("Username", new TagType("varchar(100)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("Password", new TagType("varchar(100)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("Gender", new TagType("char(1)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("PhoneNumber", new TagType("char(10)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("DOB", new TagType("date"), ldt, sdt, defdt, position++));
		account.add(new TagColumn("Email", new TagType("varchar(100)"), lstr, sstr, defstr, position++));
		account.add(new TagColumn("DateCreated", new TagType("date"), ldt, sdt, defdt, position++));
		account.add(new TagColumn("PrimeStartedDate", new TagType("date"), ldt, sdt, defdt, position++));
		account.add(new TagKeyPrimary(account.columns.get(0)));
		database.add(account);
		
		position = 3;
		TagTable seller = new TagTable("Seller");
		//SellerID has preference to the AcctID
		seller.add(new TagColumn("SellerID", new TagType("int"), lint, sint, defint, position++));
		seller.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		seller.add(new TagKeyPrimary(seller.columns.get(0)));
		seller.add(new TagKeyForeign(seller.columns.get(0), account, account.columns.get(0)));
		database.add(seller);
		
		position = 3;
		TagTable sp = new TagTable("SellerProduct");
		sp.add(new TagColumn("SellerID", new TagType("int"), lint, sint, defint, position++));
		sp.add(new TagColumn("ProductID", new TagType("int"), lint, sint, defint, position++));
		sp.add(new TagColumn("Media", new TagType("char(50)"), lstr, sstr, defstr, position++));
		sp.add(new TagColumn("Color", new TagType("char(20)"), lstr, sstr, defstr, position++));
		sp.add(new TagColumn("ShippingFee", new TagType("int"), lint, sint, defint, position++));
		sp.add(new TagKeyPrimary(sp.columns.get(0)));
		sp.add(new TagKeyPrimary(sp.columns.get(1)));
		sp.add(new TagKeyForeign(sp.columns.get(0), seller, seller.columns.get(0)));
		sp.add(new TagKeyForeign(sp.columns.get(1), product, product.columns.get(0)));
		database.add(sp);

		position = 3;
		TagTable productRating = new TagTable("ProductRating");
		productRating.add(new TagColumn("ProductID", new TagType("int"), lint, sint, defint, position++));
		productRating.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		productRating.add(new TagColumn("Rating", new TagType("int"), lint, sint, defint, position++));
		productRating.add(new TagColumn("Comments", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		productRating.add(new TagColumn("LastModified", new TagType("datetime"), ldt, sdt, defdt, position++));
		productRating.add(new TagKeyPrimary(productRating.columns.get(0)));
		productRating.add(new TagKeyForeign(productRating.columns.get(0), product, product.columns.get(0)));
		productRating.add(new TagKeyForeign(productRating.columns.get(1), account, account.columns.get(0)));
		database.add(productRating);

		position = 3;
		TagTable order = new TagTable("Order");
		order.add(new TagColumn("OrderID", new TagType("int"), lint, sint, defint, position++));
		order.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		order.add(new TagColumn("DateOrderPlaced", new TagType("datetime"), ldt, sdt, defdt, position++));
		order.add(new TagKeyPrimary(order.columns.get(0)));
		order.add(new TagKeyForeign(order.columns.get(1), account, account.columns.get(0)));
		database.add(order);
		
		position = 3;
		TagTable orderItem = new TagTable("OrderItem");
		orderItem.add(new TagColumn("OrderItemID", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagColumn("OrderID", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagColumn("SellerID", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagColumn("ProductID", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagColumn("Quantity", new TagType("int"), lint, sint, defint, position++));
		orderItem.add(new TagKeyPrimary(orderItem.columns.get(0)));
		orderItem.add(new TagKeyForeign(orderItem.columns.get(1), order, order.columns.get(0)));
		orderItem.add(new TagKeyForeign(orderItem.columns.get(2), seller, seller.columns.get(0)));
		orderItem.add(new TagKeyForeign(orderItem.columns.get(3), account, account.columns.get(0)));
		orderItem.add(new TagKeyForeign(orderItem.columns.get(4), product, product.columns.get(0)));
		database.add(orderItem);
		
		position = 3;
		TagTable returned = new TagTable("ItemReturn");
		returned.add(new TagColumn("OrderItemID", new TagType("int"), lint, sint, defint, position++));
		returned.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		returned.add(new TagColumn("Refund", new TagType("int"), lint, sint, defint, position++));
		returned.add(new TagColumn("Status", new TagType("char(20)"), lstr, sstr, defstr, position++));
		returned.add(new TagColumn("Quantity", new TagType("int"), lint, sint, defint, position++));
		returned.add(new TagColumn("DateReturned", new TagType("date"), ldt, sdt, defdt, position++));
		returned.add(new TagKeyPrimary(returned.columns.get(0)));
		returned.add(new TagKeyForeign(returned.columns.get(1), account, account.columns.get(0)));
		database.add(returned);

		position = 3;
		TagTable payment = new TagTable("Payment");
		payment.add(new TagColumn("PaymentID", new TagType("int"), lint, sint, defint, position++));
		payment.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		payment.add(new TagColumn("CardNumber", new TagType("int"), lint, sint, defint, position++));
		payment.add(new TagColumn("ExpirationDate", new TagType("date"), ldt, sdt, defdt, position++));
		payment.add(new TagKeyPrimary(payment.columns.get(0)));
		payment.add(new TagKeyForeign(payment.columns.get(1), account, account.columns.get(0)));
		database.add(payment);
		
		position = 3;
		TagTable sRating = new TagTable("SellerRating");
		sRating.add(new TagColumn("SellerID", new TagType("int"), lint, sint, defint, position++));
		sRating.add(new TagColumn("AccountID", new TagType("int"), lint, sint, defint, position++));
		sRating.add(new TagColumn("Rating", new TagType("int"), lint, sint, defint, position++));
		sRating.add(new TagColumn("LastModified", new TagType("date"), ldt, sdt, defdt, position++));
		sRating.add(new TagColumn("Comments", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		sRating.add(new TagKeyPrimary(sRating.columns.get(0)));
		sRating.add(new TagKeyPrimary(sRating.columns.get(1)));
		sRating.add(new TagKeyForeign(sRating.columns.get(0), seller, seller.columns.get(0)));
		sRating.add(new TagKeyForeign(sRating.columns.get(1), account, account.columns.get(0)));
		database.add(sRating);

		server.add(database);
		return server;
	}
}
