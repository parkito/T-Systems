/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:25
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.model.PhonesDirectoryModel', {
    extend: 'Ext.data.Model',
    fields: ['name', 'phone'],
    proxy: {
        pageParam: 'search',
        type: 'rest',
        api: {
            create: 'phone',
            read: 'phone',
            destroy: 'phone'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
});