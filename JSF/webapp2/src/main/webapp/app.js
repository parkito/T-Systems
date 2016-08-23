Ext.application({
    name: 'webapp2',
    appFolder: 'app',
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'panel',
                html: '<h2>Телефонный справочник</h2>'
            }
        });
    }
});