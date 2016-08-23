/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 1:19
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.view.SearchPhones', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchPhones',
    bodyPadding: 10,
    items: [
        {
            xtype: 'textfield',
            name: 'search',
            fieldLabel: 'Введите имя',
            maxLength: 200
        }
    ]
});
