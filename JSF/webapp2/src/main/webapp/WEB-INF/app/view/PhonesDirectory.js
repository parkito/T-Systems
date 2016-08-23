/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 1:00
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.view.PhonesDirectory', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.phonesDirectory',
    layout: 'border',
    items: [
        {
            xtype: 'phonesGrid',
            region: 'center'
        },
        {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Телефонный справочник</font></center></div>',
            region: 'north',
            height: 80
        },
        {
            xtype: 'searchPhones',
            title: 'Поиск',
            region: 'west',
            width: 300,
            collapsible: true,
            collapsed: false
        }
    ],
    renderTo: Ext.getBody()
});