/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:28
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.store.PhonesDirectoryStore', {
    extend: 'Ext.data.Store',
    model: 'PhonesDir.model.PhonesDirectoryModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
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