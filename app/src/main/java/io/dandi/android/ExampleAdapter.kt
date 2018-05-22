package io.dandi.android

/**
 * Created by nanjui on 2016. 9. 10..
 */
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.dandi.doitandroid.R

class ExampleAdapter(context: Context, val items: List<ExampleData>) : RecyclerView.Adapter<ViewHolder>() {

    private val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var onItemClick: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val mainView: View = mInflater.inflate(R.layout.layout_example_list_item, parent, false)
        mainView.setOnClickListener(onItemClick)

        return ViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.imgFlag.setImageResource(items[position].resId)
        holder.iconPrefix.setImageResource(items[position].iconPrefix)
        holder.iconSuffix.setImageResource(items[position].iconSuffix)
        holder.desc.text = items[position].desc
        holder.title.text = items[position].title
        holder.title.tag = position
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val iconPrefix = view.findViewById(R.id.__iv_icon_prefix__) as ImageView
    val iconSuffix = view.findViewById(R.id.__iv_icon_suffix__) as ImageView
    val title = view.findViewById(R.id.__tv_title__) as TextView
    val desc = view.findViewById(R.id.__tv_desc__) as TextView
}

