package br.com.carteira.acoes.Adapters.Inflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.carteira.acoes.Adapters.AdapterViewInflater;
import br.com.carteira.acoes.Adapters.BaseInflaterAdapter;
import br.com.carteira.acoes.Adapters.CardItem;
import br.com.carteira.acoes.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lucas.coelho.dutra on 22/02/2016.
 */
public class CardInflater implements AdapterViewInflater<CardItem> {

    @Override
    public View inflate(final BaseInflaterAdapter<CardItem> adapter, final int pos, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.list_item_card, parent, false);
            holder = new ViewHolder(convertView);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        final CardItem item = adapter.getTItem(pos);
        holder.updateDisplay(item);

        return convertView;
    }

    class ViewHolder
    {
        @Bind(R.id.line1) TextView m_text1;
        @Bind(R.id.line2) TextView m_text2;


        public ViewHolder(View rootView)
        {
            ButterKnife.bind(this, rootView);
            rootView.setTag(this);
        }

        public void updateDisplay(CardItem item)
        {
            m_text1.setText(item.getText1());
            m_text2.setText(item.getText2());
        }
    }
}
