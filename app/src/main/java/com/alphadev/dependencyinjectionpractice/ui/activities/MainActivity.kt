package com.alphadev.dependencyinjectionpractice.ui.activities

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.alphadev.dependencyinjectionpractice.R
import com.alphadev.dependencyinjectionpractice.databinding.ActivityMainBinding
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity
import com.alphadev.dependencyinjectionpractice.ui.adapters.ResultHistoryRecyclerAdapter
import com.alphadev.dependencyinjectionpractice.viewmodel.ResultViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : AppCompatActivity(), KoinComponent {
    val arg1: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val arg2: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val operator: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val result: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    private lateinit var adapter: ResultHistoryRecyclerAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        result.value = "0"
        arg1.value = ""
        arg2.value = ""
        operator.value = ""
        window?.statusBarColor = Color.parseColor("#e7ebd8")

        val viewModel: ResultViewModel by inject()

        arg1.observe(this) { it ->
            if (!result.value!!.equals("0")){
                result.value = arg1.value
            }else {
                result.value = ""
                result.value = arg1.value
            }
        }

        arg2.observe(this) { it ->
            val operators = arrayOf("+", "-", "*", "/")
            for (opss in operators) {
                result.value.let {
                    if (it!!.contains(opss)) {
                        Log.d("MainActivity", "onCreate: Res ${it}")
                        val bef = result.value!!.substringBefore(opss)
                        Log.d("MainActivity", "onCreate: Bef ${bef}")
                        result.value = bef.plus(operator.value.plus(arg2.value))
                    }
                }
            }
        }

        operator.observe(this) { it ->
            result.value = result.value?.plus(it)
        }

        result.observe(this) { it ->
            binding.displayNum.text = it
        }

        binding.btnPlus.setOnClickListener {
            if (!checkIfHasOperator()) {
                operator.value = binding.btnPlus.text.toString()
            }
        }

        binding.btnMinus.setOnClickListener {
            if (!checkIfHasOperator()) {
                operator.value = binding.btnMinus.text.toString()
            }
        }

        binding.btnMultiply.setOnClickListener {
            if (!checkIfHasOperator()) {
                operator.value = binding.btnMultiply.text.toString()
            }
        }

        binding.btnDivide.setOnClickListener {
            if (!checkIfHasOperator()) {
                operator.value = binding.btnDivide.text.toString()
            }
        }

        binding.btnAC.setOnClickListener {
            arg1.value = ""
            arg2.value = ""
            operator.value = ""
            result.value = "0"
        }

        binding.btnCut.setOnClickListener {
            result.let {
                it.value = it.value?.dropLast(1)
            }
        }

        binding.btnEqual.setOnClickListener {
            if (arg2.value!!.toString().isNotEmpty()) {
                Log.d("MainActivity", "onCreate: Arg1: ${arg1.value}")
                Log.d("MainActivity", "onCreate: Arg2: ${arg2.value}")
                Log.d("MainActivity", "onCreate: Operator: ${operator.value}")
                when (operator.value!!) {
                    "+" -> {
                        result.value = (arg1.value?.toDouble()?.plus(arg2.value!!.toDouble())).toString()
                    }
                    "-" -> {
                        result.value = (arg1.value?.toDouble()?.minus(arg2.value!!.toDouble())).toString()
                    }
                    "*" -> {
                        result.value = (arg1.value?.toDouble()?.times(arg2.value!!.toDouble())).toString()
                    }
                    "/" -> {
                        result.value = (arg1.value?.toDouble()?.div(arg2.value!!.toDouble())).toString()
                    }
                }
                GlobalScope.launch(Dispatchers.IO) {
                    viewModel.repository.insert(ResultHistoryEntity(result = result.value!!,
                        arg1 = arg1.value!!, arg2 = arg2.value!!, operator = operator.value!!
                    ))
                }
            }
        }

        binding.btnZero.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnZero.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnZero.text.toString().toLong())
            }
        }

        binding.btnOne.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnOne.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnOne.text.toString().toLong())
            }
        }

        binding.btnTwo.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnTwo.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnTwo.text.toString().toLong())
            }
        }

        binding.btnThree.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnThree.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnThree.text.toString().toLong())
            }
        }

        binding.btnFour.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnFour.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnFour.text.toString().toLong())
            }
        }

        binding.btnFive.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnFive.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnFive.text.toString().toLong())
            }
        }

        binding.btnSix.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnSix.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnSix.text.toString().toLong())
            }
        }

        binding.btnSeven.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnSeven.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnSeven.text.toString().toLong())
            }
        }

        binding.btnEight.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnEight.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnEight.text.toString().toLong())
            }
        }

        binding.btnNine.setOnClickListener {
            if (!checkIfHasOperator()) {
                arg1.value = arg1.value.plus(binding.btnNine.text.toString().toLong())
            }else{
                arg2.value = arg2.value.plus(binding.btnNine.text.toString().toLong())
            }
        }

        viewModel.allHistory.observe(this) { items ->
            adapter = ResultHistoryRecyclerAdapter(this@MainActivity, items)
            for (i in items) {
                Log.d("MainActivity", "onCreate: ${i.result}")
            }
        }

        binding.historyBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setCancelable(true)
            val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.history_dialog, null)
            val recycler = view.findViewById<RecyclerView>(R.id.historyRecycler)
            dialog.setView(view)
            recycler.adapter = adapter
            dialog.create().show()
        }
    }

    fun checkIfHasOperator(): Boolean {
        if (!result.value!!.contains("+")) {
            if (!result.value!!.contains("-")) {
                if (!result.value!!.contains("*")) {
                    if (!result.value!!.contains("/")) {
                        return false
                    }
                }
            }
        }
        return true
    }


}