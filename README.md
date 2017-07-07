# CommonAdapter


简单的ListViewAdapter封装

使用 : 

```
mListView = (ListView) findViewById(R.id.list_view);
mListView.setAdapter(new CommonAdapter<String>(MainActivity.this, mDatas, R.layout.item_list_view) {
  @Override
  protected void convert(ViewHolder viewHolder, String item) {
      viewHolder.setText(R.id.item_text_view, item);
  }
});
