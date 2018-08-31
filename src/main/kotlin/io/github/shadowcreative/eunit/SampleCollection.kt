package io.github.shadowcreative.eunit

class SampleCollection : EntityUnitCollection<Sample>()
{
    override fun getEntity(objectData: Any?): Sample?
    {
        return instance.getEntity(objectData)
    }

    companion object {
        val instance : SampleCollection = SampleCollection()
    }
}