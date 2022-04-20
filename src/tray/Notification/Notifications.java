/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tray.Notification;

/**
 *
 * @author ASUS
 */

public enum Notifications implements Notification {

	INFORMATION("images/info.png", "#2C54AB"),
	NOTICE("images/notice.png", "#8D9695"),
	SUCCESS("images/success.png", "#009961"),
	WARNING("images/warning.png", "#E23E0A"),
	ERROR("images/error.png", "#CC0033");

	private final String urlResource;
	private final String paintHex;

	Notifications(String urlResource, String paintHex) {
		this.urlResource = urlResource;
		this.paintHex = paintHex;
	}

	public String getURLResource() {
		return urlResource;
	}

	public String getPaintHex() {
		return paintHex;
	}

}