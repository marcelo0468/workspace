package br.com.digitalhouse.todolist.ui.recyclerviewadapter.listener;

import br.com.digitalhouse.todolist.model.Nota;

public interface OnItemClickListener {

    void onItemClick(Nota nota, int posicao);
}
