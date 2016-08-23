/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 1:44
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.view.PhonesGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.phonesGrid',
    width: 400,
    height: 300,
    frame: true,
    store: 'PhonesDirectoryStore',
    iconCls: 'icon-user',
    columns: [
        {
            text: 'Имя',
            flex: 1,
            sortable: true,
            dataIndex: 'name'

        },
        {
            flex: 2,
            text: 'Телефон',
            sortable: true,
            dataIndex: 'phone'
        }
    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add'
                },
                '-',
                {
                    action: 'delete',
                    text: 'Удалить',
                    iconCls: 'icon-delete',
                    disabled: true
                }
            ]
        }
    ]
});